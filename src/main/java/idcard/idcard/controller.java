/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idcard.idcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Zuhan
 */
@Controller
public class controller {
    @RequestMapping("/login")
    public String next(@RequestParam(value = "varA") String A,
            @RequestParam(value = "varB")
            @DateTimeFormat(pattern="EE-yyyy-MM--dd")String B,
            @RequestParam(value ="varC") MultipartFile C,
            Model model)
    throws IOException{
        
        SimpleDateFormat tanggal = new SimpleDateFormat("EE--dd--MMMM--yyyyy");
        
        byte[] img = C.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("A1",A);
        model.addAttribute("A2",B);
        model.addAttribute("A3",imglink);
    
        return "main";
    }
}