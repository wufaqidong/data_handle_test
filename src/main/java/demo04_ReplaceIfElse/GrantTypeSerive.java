package demo04_ReplaceIfElse;

/**
 * @program: a-rookie-is-a-god
 * @description:
 * @author: xiebinbin
 * @create: 2022-07-06 19:05
 **/

public class GrantTypeSerive {
    public String redPaper(String resourceId){
        //红包的发放方式
        return "每周末9点发放";
    }
    public String shopping(String resourceId){
        //购物券的发放方式
        return "每周三9点发放";
    }
    public String qQVip(String resourceId){
        //qq会员的发放方式
        return "每周一0点开始秒杀";
    }
}
