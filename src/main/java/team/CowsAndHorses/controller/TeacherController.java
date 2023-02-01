package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.service.TeacherService;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
@SessionAttributes(names = "teacher",types = Teacher.class)
public class TeacherController {

    final TeacherService teacherService;

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestBody Teacher teacher) {
        boolean flag; String msg;
        if(teacherService.register(teacher)>0){
             flag= true;
             msg="注册成功！";
        }
        else {
            flag = false;
            msg="注册失败！";
        }
        return new Result(flag ? Code.REGISTER_OK:Code.REGISTER_ERR,flag,msg);
    }

      @RequestMapping("/login")
      @ResponseBody
    public Result login(@RequestBody Teacher teacher, HttpSession session) {
       Teacher t= teacherService.login(teacher);
          boolean flag; String msg;int id;
        if (t != null) {

            Teacher t1=teacherService.selectByName(t.getUsername());
            flag=true;
           msg="登录成功！";
            session.setAttribute("teacher",t1);
            id=t1.getModuleId();
        }
        else {
            flag = false;
            msg = "登录失败!";
            id=0;
        }
          return new Result(flag ? Code.LOGIN_OK:Code.LOGIN_ERR,id,msg);
    }

    @RequestMapping(value ="/change/password", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Map<String, Object> map,HttpSession session ){
        boolean flag; String msg;

      Teacher t= (Teacher) session.getAttribute("teacher");
      String password=t.getPassword();


        String oldPwd= (String) map.get("old_pwd");
        String newPwd= (String) map.get("new_pwd");

        if(password.equals(oldPwd) && newPwd!=null){
            t.setPassword(newPwd);
            if(teacherService.update(t)>0) {
                flag = true;
                msg = "修改密码成功！";
            }
            else {
                flag=false;
                msg="修改密码失败！";
            }
        }
        else{
            flag=false;
            msg="修改密码失败！";
        }

        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag,msg);
    }

    @RequestMapping("/set/time")
    @ResponseBody
    public Result setTime(@RequestBody Map<String,Object> map){
        int year= (int) map.get("year");
        int month= (int) map.get("month");
        int day= (int) map.get("day");
        int hour= (int) map.get("hour");
        String minute= (String) map.get("minute");
        Time t=new Time();
        t.setYear(year);
        t.setMonth(month);
        t.setDay(day);
        t.setHour(hour);
        t.setMinute(minute);
        if(teacherService.setTime(t)>0){
            return  new Result(Code.SET_TIME_OK,true,"设置成功");
        }

        return  new Result(Code.SET_TIME_ERR,false,"设置失败");

    }



//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable Integer id) {
//        return bookService.delete(id);
//    }
//
//    @GetMapping("/{id}")
//    public Book getById(@PathVariable Integer id) {
//        return bookService.getById(id);
//    }
//
//    @GetMapping
//    public List<Book> getAll() {
//        return bookService.getAll();
//    }
}
