package com.hzwtech.cqwjs.drools.example.model;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/9
 * @since v1.0
 */

public class Server {

    private String name;
    private int processors;
    private int memory;
    private int diskspace;
    private boolean isValid=true;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Server(String name, int processors, int memory, int diskspace) {
        this.name = name;
        this.processors = processors;
        this.memory = memory;
        this.diskspace = diskspace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDiskspace() {
        return diskspace;
    }

    public void setDiskspace(int diskspace) {
        this.diskspace = diskspace;
    }
}