package indi.wsn.mytask.anno;


import java.lang.annotation.*;

/**
 * 自定义注解
 * Created by SharingWoo on 2017/2/24.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyComponent {
}
