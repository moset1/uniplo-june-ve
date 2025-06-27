let isEmailChecked = false;
let isAuthCodeVerified = false;

document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");

    // 이메일이 바뀌면 인증 상태 초기화
    const emailInput = document.getElementById('user_email');
    emailInput.addEventListener('input', () => {
        isEmailChecked = false;
        isAuthCodeVerified = false;
        document.getElementById('EmailCheckResult').innerText = '';
        document.getElementById('authCodeResult').innerText = '';
    });

    form.addEventListener("submit", function (e) {
        const password = form.user_password.value.trim();

        if (!isEmailChecked) {
            alert("이메일 중복 확인을 완료해주세요.");
            e.preventDefault();
            return;
        }

        if (!isAuthCodeVerified) {
            alert("이메일 인증을 완료해주세요.");
            e.preventDefault();
            return;
        }

        if (password.length < 8 || password.length > 20) {
            alert("비밀번호는 8자 이상 20자 이하로 입력해주세요.");
            e.preventDefault();
            return;
        }

        const requiredFields = ["user_email", "user_last_name", "user_first_name", "user_phone_number", "user_birth_date"];
        for (const name of requiredFields) {
            if (!form[name].value.trim()) {
                alert("모든 항목을 입력해주세요.");
                e.preventDefault();
                return;
            }
        }
    });
});

function checkDuplicateEmail() {
    const user_email = document.getElementById('user_email').value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(user_email)) {
        document.getElementById('EmailCheckResult').innerText = '올바른 이메일 형식을 입력해주세요.';
        isEmailChecked = false;
        return;
    }

    fetch(contextPath + '/signup/check-email?user_email=' + encodeURIComponent(user_email))
        .then(response => response.text())
        .then(result => {
            if (result === 'OK') {
                document.getElementById('EmailCheckResult').innerText = '사용 가능한 이메일입니다.';
                isEmailChecked = true;
            } else {
                document.getElementById('EmailCheckResult').innerText = '이미 사용 중인 이메일입니다.';
                isEmailChecked = false;
            }
        });
}

function sendAuthCode() {
    const user_email = document.getElementById('user_email').value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(user_email)) {
        document.getElementById('authCodeResult').innerText = '유효한 이메일을 입력해주세요.';
        return;
    }

    fetch(contextPath + '/signup/send-auth-code?user_email=' + encodeURIComponent(user_email))
        .then(response => response.text())
        .then(result => {
            if (result === 'OK') {
                document.getElementById('authCodeResult').innerText = '인증코드가 이메일로 전송되었습니다.';
            } else {
                document.getElementById('authCodeResult').innerText = '인증코드 발송에 실패했습니다.';
            }
        });
}

function verifyAuthCode() {
    const inputCode = document.getElementById('auth_code').value;

    if (!inputCode.trim()) {
        document.getElementById('authCodeResult').innerText = '인증코드를 입력해주세요.';
        isAuthCodeVerified = false;
        return;
    }

    fetch(contextPath + '/signup/verify-auth-code', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'inputCode=' + encodeURIComponent(inputCode)
    })
        .then(response => response.text())
        .then(result => {
            if (result === 'VERIFIED') {
                document.getElementById('authCodeResult').innerText = '인증 성공!';
                isAuthCodeVerified = true;
            } else if (result === 'EXPIRED') {
                document.getElementById('authCodeResult').innerText = '인증코드가 만료되었습니다.';
                isAuthCodeVerified = false;
            } else {
                document.getElementById('authCodeResult').innerText = '인증코드가 일치하지 않습니다.';
                isAuthCodeVerified = false;
            }
        });
}
