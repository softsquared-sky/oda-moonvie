package soft.pro.oda.src.Signup.interfaces;

public interface SignupActivityView {

    void validateSuccess(int code,String text);

    void validateFailure(String message);


    void userSuccess(int code,String text);
    void userFailure(int code,String message);
}
