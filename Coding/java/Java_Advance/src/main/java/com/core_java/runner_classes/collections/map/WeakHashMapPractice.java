package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        // not extend to hashmap but map and abstract map

        // Let's say you want to use images in your application a lot more times.
        // So, better to save them in cache with some key values (so that you can
        // retrieve it) but after using it, they should be automatically removed
        WeakHashMap<String,Image> imageCache = new WeakHashMap<>();

        // case 1
        // this thing will not work as Strings are always strongly referenced,
        // so we need to put their weak reference;
        System.out.println("Strong referenced key");
        imageCache.put("Image1",new Image("Image1"));
        imageCache.put("Image2",new Image("Image2"));
        imageCache.put("Image3",new Image("Image3"));
        imageCache.values().forEach(System.out::println);
        System.gc();
        someApplicationWork();
        imageCache.values().forEach(System.out::println);
        imageCache.clear();

        // case 2
        // here keys are weak reference as we don't have any strong reference to them
        System.out.println("weak referenced key");
        imageCache.put(new String("Image1"),new Image("Image1"));
        imageCache.put(new String("Image2"),new Image("Image2"));
        imageCache.put(new String("Image3"),new Image("Image3"));
        imageCache.values().forEach(System.out::println);
        System.gc();
        someApplicationWork();
        System.out.println(imageCache);
        imageCache.clear();

        // case 3
        // fill a map inside method
        System.out.println("out of scope variable");
        loadCache(imageCache);
        System.gc();
        someApplicationWork();
        System.out.println(imageCache);
        imageCache.clear();
    }

    private void someApplicationWork(){
        try {
            Thread.sleep(10000);
        }catch(Exception ignored){}
    }

    private void loadCache(Map<String,Image> imageCache){
        String k1= new String("Image1");
        String k2= new String("Image2");
        String k3= new String("Image3");

        imageCache.put(k1,new Image("Image1"));
        imageCache.put(k2,new Image("Image2"));
        imageCache.put(k3,new Image("Image3"));
        imageCache.values().forEach(System.out::println);
    }

}

class Image{
    private String image;
    public Image(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image='" + image + '\'' +
                '}';
    }
}
