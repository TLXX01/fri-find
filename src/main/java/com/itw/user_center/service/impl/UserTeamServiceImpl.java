package com.itw.user_center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itw.user_center.model.domain.UserTeam;
import com.itw.user_center.service.UserTeamService;
import com.itw.user_center.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author 王钟轩
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-01-27 13:48:18
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




