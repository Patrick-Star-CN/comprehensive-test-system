package  team.CowsAndHorses.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.StuInfoService;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class StuInfoController {

    @Autowired
    private StuInfoService stuservice;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody StuInfoEntity stuentity, HttpSession session){
        StuInfoEntity stu =stuservice.login(stuentity);
        Result res = new Result();
        if(stu!=null){
            res.setCode(1);
            res.setData(null);
            res.setMsg("登录成功");
            session.setAttribute("student",stu);
            return res;
        }
        else {
            res.setCode(1);
            res.setData(null);
            res.setMsg("登录失败");
            return res;
        }
    }

    @RequestMapping("/changepassword")
    @ResponseBody
    public Result changePsd (@RequestBody Map<String,Object> map, HttpSession session){
        Result res=new Result();
        StuInfoEntity stu=(StuInfoEntity) session.getAttribute("student");
        String psw=stu.getStuPassword();
        String oldPassword= (String) map.get("old_password");
        String newPassword= (String) map.get("new_password");
        if(psw.equals(oldPassword)&&newPassword!=null){
            stu.setStuPassword(newPassword);
            if(stuservice.changePassword(stu)>0){
                res.setCode(2);
                res.setData(null);
                res.setMsg("修改成功");
                return res;
            }else {
                res.setCode(2);
                res.setData(null);
                res.setMsg("修改失败");
                return res;
            }
        }
        else{
            res.setCode(2);
            res.setData(null);
            res.setMsg("修改失败");
            return res;
        }
    }



}
