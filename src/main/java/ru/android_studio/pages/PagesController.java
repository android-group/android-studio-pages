package ru.android_studio.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Controller
@RequestMapping("/api/pages")
public class PagesController {
    @RequestMapping(method = RequestMethod.GET, value = "/page")
    public void getPageForId(HttpServletResponse httpServletResponse,
                                 @RequestParam(value = "id") int id,
                                 Locale locale) throws IOException {
    }
}