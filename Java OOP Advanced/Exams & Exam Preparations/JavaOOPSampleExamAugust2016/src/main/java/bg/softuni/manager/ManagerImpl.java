package bg.softuni.manager;

import bg.softuni.factories.CoreFactory;
import bg.softuni.factories.FragmentFactory;
import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.Manager;
import bg.softuni.util.Const;

import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements Manager {

    private List<Core> cores;
    private Core selectedCore;

    public ManagerImpl() {
        this.cores = new ArrayList<>();
    }

    @Override
    public String createCore(String[] args) {
        String type = args[0];
        Integer durability = Integer.parseInt(args[1]);
        try {
            Core core = CoreFactory.createCore(type, durability);
            cores.add(core);
            return String.format(Const.ADD_CORE_SUCCESS_MESSAGE, core.getName());
        } catch (Exception e) {
            return Const.ADD_CORE_ERROR_MESSAGE;
        }
    }

    @Override
    public String removeCore(String[] args) {
        String name = args[0];
        if (this.cores.stream().noneMatch(x -> x.getName().equalsIgnoreCase(name))) {
            return Const.REMOVE_CORE_ERROR_MESSAGE;
        }
        cores.removeIf(x -> x.getName().equalsIgnoreCase(name));
        if(this.selectedCore.getName().equalsIgnoreCase(name)){
            this.selectedCore = null;
        }
        return String.format(Const.REMOVE_CORE_SUCCESS_MESSAGE, name);
    }

    @Override
    public String selectCore(String[] args) {
        String name = args[0];
        if (this.cores.stream().noneMatch(x -> x.getName().equalsIgnoreCase(name))) {
            return String.format(Const.SELECT_CORE_ERROR_MESSAGE, name);
        }
        this.selectedCore = this.cores.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
        return String.format(Const.SELECT_CORE_SUCCESS_MESSAGE, name);
    }

    @Override
    public String attachFragment(String[] args) {
        String type = args[0];
        String name = args[1];
        Integer pressureAffection = Integer.parseInt(args[2]);
        try {
            Fragment fragment = FragmentFactory.createFragment(name, type, pressureAffection);
            if (this.selectedCore == null) {
                return String.format(Const.ATTACH_FRAGMENT_ERROR_MESSAGE, name);
            }
            this.selectedCore.getFragments().push(fragment);
            return String.format(Const.ATTACH_FRAGMENT_SUCCESS_MESSAGE, name, this.selectedCore.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return String.format(Const.ATTACH_FRAGMENT_ERROR_MESSAGE, name);
        }
    }

    @Override
    public String detachFragment(String[] args) {
        if(this.selectedCore == null){
            return Const.DETACH_FRAGMENT_ERROR_MESSAGE;
        } else if(this.selectedCore.getFragments().isEmpty()){
            return Const.DETACH_FRAGMENT_ERROR_MESSAGE;
        }
        Fragment fragment = this.selectedCore.getFragments().pop();
        return String.format(Const.DETACH_FRAGMENT_SUCCESS_MESSAGE, fragment.getName(), this.selectedCore.getName());
    }

    @Override
    public String status(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Lambda Core Power Plant Status: %n" +
                "Total Durability: %d%n" +
                "Total Cores: %d%n" +
                "Total Fragments: %d",
                this.cores.stream().mapToInt(Core::getDurability).sum(),
                this.cores.size(),
                this.cores.stream().mapToInt(x -> x.getFragments().size()).sum()));
        this.cores.forEach(sb::append);
        return sb.toString();
    }
}
