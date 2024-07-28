package statemachine;

public class StateMachineTest {

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine("AA");
        int result = stateMachine.search("BAAABBBB");
        System.out.println(result);
        result = stateMachine.searchKmp("BAAABBBB", "AA");
        System.out.println(result);
    }
}
