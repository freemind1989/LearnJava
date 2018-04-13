package com.ljd.serializable;

import java.io.*;

public class TestSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int staticVar = 5;
    public String var = "test serializable";

    public static void main(String[] args) {
        try {
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
            out.writeObject(new TestSerializable());
            out.close();

            //序列化后修改为10
            TestSerializable.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
            TestSerializable t = (TestSerializable) oin.readObject();
            oin.close();

            //再读取，通过t.staticVar打印新的值
            System.out.println(t.staticVar);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
