package com.yong.cdf.util;

import com.yong.cdf.VO.ResultVO;
import com.yong.cdf.entity.ProductInfo;
import com.yong.cdf.enums.ResultEnum;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        ResultVO<ProductInfo> resultVO=success(null);
        return resultVO;
    }

    public static ResultVO error(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(ResultEnum.FAILURE.getCode());
        resultVO.setMsg("失败");
        return resultVO;
    }



}
