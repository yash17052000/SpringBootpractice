package CreationOfThreads;
//facade by coder army

class PowerSupply {
    public void powersupply(){
        System.out.println("Supply is provided");
    }
}

class CoolingSystem {
    public void fanstarted(){
        System.out.println("Fan has started");
    }
}
class CPU {
    public void intialize(){
        System.out.println("CPU intiialied started");
    }
}
class Memory {
    public void memorystarted(){
        System.out.println("Memory is started");
    }
}
class BIOS{
    public void boot(CPU cpu,Memory memory){
     cpu.intialize();
     memory.memorystarted();
    }
}

class ComputerFacade{
    private Memory memory;
    private BIOS bios;
    private CoolingSystem coolingSystem;
    private PowerSupply powerSupply;
    private CPU cpu;
      public ComputerFacade() {
        memory = new Memory();
        bios = new BIOS();
        coolingSystem = new CoolingSystem();
        powerSupply = new PowerSupply();
        cpu = new CPU();
    }
    public void starttheCOmputer(){
        System.out.println("started the computer ");
        powerSupply.powersupply();
        coolingSystem.fanstarted();
        bios.boot(cpu, memory);
        memory.memorystarted();
        System.out.println("Booted succesfully");
    }
}
public class FacadeDesginPattern {
    public static void main(String[] args) {
        ComputerFacade computerFacade= new ComputerFacade();
        computerFacade.starttheCOmputer();
    }
    
}
