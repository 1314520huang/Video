package com.video.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Remarks {
	String value() default "";
	String module() default "";
	String type1() default "";
	String type2() default "";
	String type3() default "";
	String eventId() default "";
	String platform() default "";
	String operateType() default "";
}
