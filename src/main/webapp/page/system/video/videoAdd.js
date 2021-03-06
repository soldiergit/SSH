layui.config({
    base: $config.resUrl+"js/" //定义基目录
}).extend({
    ajaxExtention:'ajaxExtention', //加载自定义扩展
    $tool:'tool',
    $api:'api',
}).use(['form','layer','$tool','$api'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        $tool=layui.$tool,
        $api = layui.$api;

    //渲染下拉框
    $api.GetAreaList({page: 1, limit: 999999//Number.MAX_VALUE
    },function (data) {
        $.each(data.data,function (index, item) {
            $(".areaOfVideoId").append(new Option(item.areaName,item.areaId));
        });
        layui.form.render("select");
    },function (data) {
        layer.msg("请求区域错误:"+data.valueOf());
        return false;
    });

    form.on("submit(addUser)",function(data){
        //新增,更新
        var updateFlag = $(".updateFlag").val().valueOf();//0:添加 1:更新
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.post(updateFlag==='0'?$tool.getResUrl()+"sysJson/video_addVideo.action":$tool.getResUrl()+"sysJson/video_updateVideo.action",{//
            videoId : updateFlag==='0'?null:$(".Id").val(),//id
            videoCode : $(".videoCode").val(),
            positionName : $(".positionName").val(),
            videoLal : $(".videoLal").val(),
            videoIp : $(".videoIp").val(),
            areaOfVideoId : data.field.areaOfVideoId//所属区域
        },function(res){
            if (res.code === 0){
                top.layer.close(index);
                top.layer.msg(updateFlag==='0'?"添加成功！":"修改成功");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }else {
                top.layer.close(index);
                top.layer.msg("操作失败！");
            }
        })
        return false;
    })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})