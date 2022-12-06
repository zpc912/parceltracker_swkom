package at.fhtw.swen3.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ApiUtil {
    public static void setExampleResponse(NativeWebRequest request, String contentType, String example) {
        try {
            HttpServletResponse response = request.getNativeResponse(HttpServletResponse.class);
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Type", contentType);
            response.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}