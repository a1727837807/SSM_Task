package cn.zqq.Controller;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

/**
 * class创建日期
 *
 * @date 2020/9/813:11
 */
public class MyPropertyRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(Integer.class,new CustomNumberEditor(Integer.class,false));
    }
}
