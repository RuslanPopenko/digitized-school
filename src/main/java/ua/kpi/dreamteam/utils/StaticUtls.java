package ua.kpi.dreamteam.utils;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Created by ruslan on 23.10.16.
 */
public class StaticUtls {

    public static boolean nullAwareBeanCopy(Object dest, Object source) throws IllegalAccessException, InvocationTargetException {
        final boolean [] isCopied = {false};
        new BeanUtilsBean() {
            @Override
            public void copyProperty(Object dest, String name, Object value)
                    throws IllegalAccessException, InvocationTargetException {
                if (value instanceof Collection<?>) {
                    if (!((Collection) value).isEmpty()) {
                        super.copyProperty(dest, name, value);
                        isCopied[0] = true;
                    }
                } else if (value != null) {
                    super.copyProperty(dest, name, value);
                    isCopied[0] = true;
                }
            }
        }.copyProperties(dest, source);

        return isCopied[0];
    }

    public static String deleteSuffixOptional(String str, String sfx) {
        return str.endsWith(sfx) ? str.substring(0, str.indexOf(sfx)) : str;
    }

}
