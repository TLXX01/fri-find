package com.itw.user_center.service;

import com.itw.user_center.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itw.user_center.model.domain.User;
import com.itw.user_center.model.dto.TeamQuery;
import com.itw.user_center.model.request.TeamJoinRequest;
import com.itw.user_center.model.request.TeamQuitRequest;
import com.itw.user_center.model.request.TeamUpdateRequest;
import com.itw.user_center.model.vo.TeamUserVO;

import java.util.List;

/**
* @author 王钟轩
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-01-27 13:45:58
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     *
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     *
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     *
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);

}
