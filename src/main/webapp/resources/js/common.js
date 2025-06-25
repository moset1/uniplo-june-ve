document.addEventListener("DOMContentLoaded", function () {
    const dropdowns = document.querySelectorAll(".dropdown");

    dropdowns.forEach((dropdown) => {
        let timeout;

        dropdown.addEventListener("mouseenter", () => {
            clearTimeout(timeout);
            dropdown.classList.add("open");
        });

        dropdown.addEventListener("mouseleave", () => {
            timeout = setTimeout(() => {
                dropdown.classList.remove("open");
            }, 200);
        });
    });
});
