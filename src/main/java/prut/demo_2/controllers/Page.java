package prut.demo_2.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vasyl savitskyy on 20.11.2019.
 */
@Controller
@RequestMapping(value = "/")
public class Page {

    @Value("${frontend.mode}")
    private String frontendMode;

    @GetMapping(value = "info")
    public ModelAndView info() {
        Map<String, String> model = new HashMap<>();
        String name = "Створення нового користувача";

        model.put("message", name);

        return new ModelAndView("fragments/pages/info", model);
    }

    @GetMapping(value = "app")
    public String app(Model model) {
        Map<String, Object> data = new HashMap<>();
        data.put("a", 12L);
        data.put("name", "Vasyl");
        data.put("auth", true);
        model.addAttribute("frontendData", data);

        String message = "some message from server";
        model.addAttribute("message", message);
        model.addAttribute("isDevMode", frontendMode);

//        File appWebpackDirectory = new File(Boolean.valueOf(frontendMode) ? "http://localhost:8081/" : "src/main/resources/static/app-webpack/dist");
//        List <String> listJS = new ArrayList<>();
//        if (appWebpackDirectory.isDirectory()) {
//            for (File item : appWebpackDirectory.listFiles()) {
//                if (item.getName().endsWith(".js")) {
//                    listJS.add(item.getName());
//                }
//            }
//        }
//        model.addAttribute("listJS", listJS);
        return "fragments/pages/app";
    }

//    @RequestMapping(value = "socialProgram/{dateFrom}/{dateTo}")
//    public @ResponseBody
//    ResponseEntity getSocialProgramReport(@PathVariable("dateFrom") Long dateFrom,
//                                          @PathVariable("dateTo") Long dateTo){
//        List cashCollections = goodsReportService.getSocialProgramsBetweenDates(new Date(dateFrom), new Date(dateTo));
//        return ResponseEntity.ok(cashCollections);
//    }

}
