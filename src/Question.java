public class Question {
    private String title;//真实题目
    private  String answer;//真实答案
    //构造方法初始化题目
    public Question(String title,String answer){
        this.title = title;
        this.answer = answer;
    }
    //提供教师所需要的答案的方法
    public String getAnswer() {
        return answer;
    }
    //提供题目的方法
    public String getTitle(){
        return this.title;
    }
    //重写方法   将默认比较题目对象的地址规则  改成 比较题干  题干一致认为是同一个题目
    public boolean equals(Object obj){
        //若两个对象是同一个 就不用比了 直接返回true
        if(this==obj){
            return true;
        }
        //判断obj是不是类型正确  是就造型 然后按照既定规则比较即可
        if(obj instanceof Question){
            Question anotherQuestion = (Question)obj;
            if(this.title.equals(anotherQuestion.title)){
                return true;
            }
        }
        //不是当前对象又不是同一类型 那就直接返回false
        return  false;
    }
    public int hashcode(){
        return  this.title.hashCode();
    }
}
