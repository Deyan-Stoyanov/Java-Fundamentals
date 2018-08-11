import abstractions.*;
import commands.GroupAttackCommand;
import commands.GroupTargetCommand;
import excutors.CommandExecutor;
import loggers.CombatLogger;
import loggers.EventLogger;
import mediators.Group;
import models.Dragon;
import models.Warrior;

public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);

        Attacker attacker = new Warrior("Pesho", 10, combatLogger);
        Attacker attacker2 = new Warrior("Gosho", 10, combatLogger);
        Attacker attacker3 = new Warrior("Ivan", 10, combatLogger);
        Target target = new Dragon("Dragon", 30, 5, combatLogger);
        Executor executor = new CommandExecutor();
        AttackGroup group = new Group();
        group.addMember(attacker);
        group.addMember(attacker2);
        group.addMember(attacker3);
        Command groupTargetCommand = new GroupTargetCommand(group, target);
        Command groupAttackCommand = new GroupAttackCommand(group);
        executor.executeCommand(groupTargetCommand);
        executor.executeCommand(groupAttackCommand);

        Observer observer = new Warrior("Pesho", 10, combatLogger);
        Observer observer2 = new Warrior("Gosho", 10, combatLogger);
        Observer observer3 = new Warrior("Ivan", 10, combatLogger);
        Subject subject = new Dragon("Dragon", 30, 5, combatLogger);
        subject.register(observer);
        subject.register(observer2);
        subject.register(observer3);
        AttackGroup attackGroup = new Group();
        Executor codeExecutor = new CommandExecutor();
        attackGroup.addMember((Attacker) observer);
        attackGroup.addMember((Attacker) observer2);
        attackGroup.addMember((Attacker) observer3);
        Command groupTarget = new GroupTargetCommand(attackGroup, (Target)subject);
        Command groupAttack = new GroupAttackCommand(attackGroup);
        codeExecutor.executeCommand(groupTarget);
        codeExecutor.executeCommand(groupAttack);
    }
}
