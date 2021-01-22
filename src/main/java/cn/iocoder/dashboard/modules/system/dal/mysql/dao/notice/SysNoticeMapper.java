package cn.iocoder.dashboard.modules.system.dal.mysql.dao.notice;

import cn.iocoder.dashboard.framework.mybatis.core.query.QueryWrapperX;
import cn.iocoder.dashboard.framework.mybatis.core.util.MyBatisUtils;
import cn.iocoder.dashboard.modules.system.controller.notice.vo.SysNoticePageReqVO;
import cn.iocoder.dashboard.modules.system.dal.mysql.dataobject.notice.SysNoticeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysNoticeMapper extends BaseMapper<SysNoticeDO> {

    default IPage<SysNoticeDO> selectList(SysNoticePageReqVO reqVO) {
        return selectPage(MyBatisUtils.buildPage(reqVO),
                new QueryWrapperX<SysNoticeDO>().likeIfPresent("title", reqVO.getTitle())
                        .eqIfPresent("status", reqVO.getStatus()));
    }

}