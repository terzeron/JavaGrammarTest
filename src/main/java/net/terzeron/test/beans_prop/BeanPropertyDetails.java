package net.terzeron.test.beans_prop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Created by terzeron on 2016. 8. 11..
 */
public class BeanPropertyDetails {
    public static void main(String[] args) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(Bean.class);
            // 사용자가 정의한 Bean 이라는 이름의 클래스로부터 bean info를 꺼내옴
            // bean info란  클래스 내부의 멤버 변수에 대한 이름과 타입 정보
        } catch (IntrospectionException exception) {
            exception.printStackTrace();
        }

        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < descriptors.length; i++) {
            String propName = descriptors[i].getName();
            Class<?> propType = descriptors[i].getPropertyType();
            System.out.println("Property with name: " + propName + " and type: " + propType);
        }
    }
}
