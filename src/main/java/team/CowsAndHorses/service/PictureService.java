package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.PictureEntity;

@Transactional
public interface PictureService {

    public int subPicture(PictureEntity p);
    public int getPicture(PictureEntity p);
    public int delPicture(PictureEntity p);
}
