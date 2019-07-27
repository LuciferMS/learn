package pattern.proxy.staticProxy;

import pattern.proxy.ISkillAction;
import pattern.proxy.Star;

/**
 * @program: learn
 * @description: 代理人
 * @author: Elliot
 * @create: 2019-07-21 13:58
 **/
public class Agent implements ISkillAction {

    private Star star;

    public Agent(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("经纪人首先安排本次行程计划...");
        System.out.println("经纪人跟活动商进行唱歌前的布置...");
        star.sing();
        System.out.println("经纪人跟活动商做收尾工作...(例如收钱...)");
        System.out.println("本次行程结束，经纪人安排新的计划...");
    }

    @Override
    public void dance() {

    }

    @Override
    public void rapping() {

    }
}