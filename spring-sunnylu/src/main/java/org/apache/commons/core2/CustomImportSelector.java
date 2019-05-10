package org.apache.commons.core2;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 返回的指定ClassName的bean会交给spring容器管理
 * 原理见《spring源码解析4》
 */
public class CustomImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{AopBeanPostProcessor.class.getName()};
	}
}
