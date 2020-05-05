import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ExamMachine {
    //属性---记录学生账号和密码
    private HashMap<String,String> userBox= new HashMap<String,String>();
    {
        userBox.put("缪永金","666");
        userBox.put("周文筱","666");
        userBox.put("李至","666");
    }




    //属性---题库  好多个Question类型的对象  每一个对象是一道题目
    //  Set集合  如果题库进行扩充 产生重复题目可以自动去掉了
    //  hash集合遵循的规则  equals和hashCode方法
    private HashSet<Question> questionBank = new HashSet<Question>();
    {
        questionBank.add(new Question("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A"));
        questionBank.add(new Question("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A"));
        questionBank.add(new Question("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个是java.util包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        questionBank.add(new Question("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        questionBank.add(new Question("以下选项哪个是String类中方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        questionBank.add(new Question("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        questionBank.add(new Question("以下选项哪个不是Set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));
    }


    //设计一个方法 随机生成试卷
    //      参数 确定试卷5道题 不用  返回值-->试卷ArrayList<Question>
    public ArrayList<Question> creatPaper(){
        //我们要创建试卷 就要从题库里面抽取 由于题库HashSet集合 没有顺序 不好通过数学的random类随机生成index
        //随机抽取试卷的时候  试卷的题目应该是不重复  set存
        HashSet<Question> paper = new HashSet<Question>();//试卷
        //所以我们要先创建ArrayList来给定题库集合顺序
        ArrayList<Question> questionBank = new ArrayList<Question>(this.questionBank);
        while (paper.size()!=5){
            //创建一个random对象来获得随机值
            int index = new Random().nextInt(this.questionBank.size());
            //通过获取的索引值从ArrayList题库中中找到对应的题目并且加到试卷里面去
            paper.add(questionBank.get(index));
        }
        //最后将获得paper转换回ArrayList集合传出去
        return new ArrayList<Question>(paper);
    }

    public String login(String username,String password){
       String realPassWord= this.userBox.get(username);
       if(realPassWord!=null&&realPassWord.equals(password)){
           return "登录成功";
       }
        return "用户名或密码错误";

    }

}
