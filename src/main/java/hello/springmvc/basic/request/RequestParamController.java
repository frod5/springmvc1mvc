package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@Slf4j
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}",username);
        log.info("age = {}",age);

        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username = {}",memberName);
        log.info("age = {}", memberAge);
        return "ok";
    }

    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username ,@RequestParam int age) {

        log.info("username = {}",username);
        log.info("age = {}", age);
        return "ok";
    }

    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username , int age) {

        log.info("username = {}",username);
        log.info("age = {}", age);
        return "ok";
    }

    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username ,
            @RequestParam(required = false) int age) {

        log.info("username = {}",username);
        log.info("age = {}", age);
        return "ok";
    }

    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "kim") String username ,
            @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username = {}",username);
        log.info("age = {}", age);
        return "ok";
    }

    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {


        log.info("username = {}",paramMap.get("username"));
        log.info("age = {}", paramMap.get("age"));
        return "ok";
    }
}
