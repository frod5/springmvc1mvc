package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mv = new ModelAndView("response/hello")
                .addObject("data", "hello");

        return mv;
    }



    //타임 리프를 사용하면 application.properties 파일에 default로 설정.
    //spring.thymeleaf.prefix=classpath:/templates/
    //spring.thymeleaf.suffix=.html

    //그래서 해당 view를 찾을 수 있는 것.
    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
        model.addAttribute("data","hello!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")  //이 방식은 권장하지 않음.
    public void responseView3(Model model) {
        model.addAttribute("data","hello!");
    }
}
