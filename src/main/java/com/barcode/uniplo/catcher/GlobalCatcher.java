package com.barcode.uniplo.catcher;


import com.barcode.uniplo.exception.UnauthorizedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalCatcher {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model m) {
        m.addAttribute("errorCode", 404);
        m.addAttribute("message", "페이지를 찾을 수 없습니다.");
        m.addAttribute("ex", ex);
        return "error/404error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String catcher(Exception ex, Model m) {
        m.addAttribute("errorCode", 500);
        m.addAttribute("message", "서버 에러가 발생했습니다.");
        m.addAttribute("ex", ex);
        return "error/error";
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public String handleUnauthorized(UnauthorizedAccessException e, RedirectAttributes ra) {
        ra.addFlashAttribute("alertMessage", e.getMessage());
        return "redirect:/post/list";
    }

}
