package team.CowsAndHorses.service;

import team.CowsAndHorses.domain.ContentEntity;

public interface ContentService {
    public int deleteCon(ContentEntity c);
    public int subCon(ContentEntity c);
    public int selectCom(ContentEntity c);
}
