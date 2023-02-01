package  team.CowsAndHorses.controller;



import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.PictureEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.PictureService;

import java.util.List;
import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class PictureController {
    final PictureService picservice;

    @RequestMapping("/subpicture")
    @ResponseBody
    public Result subPicture(@RequestBody Map<String,Object> map, HttpSession session){
        Result res=new Result();
        StuInfoEntity tempStu =(StuInfoEntity) session.getAttribute("student");
        String num= tempStu.getStuNumber();

        int moduleid=(int)map.get("moduleId");
        int year=(int)map.get("year");
        List<String> l= (List<String>) map.get("photo");

        PictureEntity p=new PictureEntity();
        p.setStuNumber(num);
        p.setYear(year);
        p.setModuleId(moduleid);

        int j=0;
        int len=l.size();
        for(int i=0;i<len;i++) {
            p.setPhoto(l.get(i));
            if (picservice.getPicture(p) > 0) {
                picservice.delPicture(p);
                j = picservice.subPicture(p);
            }
            else {
                j = picservice.subPicture(p);
            }
        }
        if(j>0){
            res.setCode(3);
            res.setData(null);
            res.setMsg("提交成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("提交失败");
            return res;
        }
    }

}
