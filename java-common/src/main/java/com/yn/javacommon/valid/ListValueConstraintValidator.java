package com.yn.javacommon.valid;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        if (ObjectUtils.isNotEmpty(vals)) {
            for (int val : vals) {
                set.add(val);
            }
        }
    }

    //判断是否校验成功

    /**
     * @param value   需要校验的值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        //包不包含都是这个
        return set.contains(value);
    }
}
