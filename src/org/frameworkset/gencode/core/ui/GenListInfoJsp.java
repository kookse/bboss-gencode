package org.frameworkset.gencode.core.ui;

import java.io.File;

import org.frameworkset.gencode.core.AbstractGencode;
import org.frameworkset.gencode.core.GencodeServiceImpl;

import bboss.org.apache.velocity.Template;
import bboss.org.apache.velocity.VelocityContext;

import com.frameworkset.util.VelocityUtil;

public class GenListInfoJsp  extends AbstractGencode {

	public GenListInfoJsp(GencodeServiceImpl gencodeService) {
		super(gencodeService);
		// TODO Auto-generated constructor stub
	}

	
	public void gen()
	{
		File conf = gencodeService.getListInfoJsp();
		if(conf.exists())
		{
			conf.delete();
		}
		try {
			conf.createNewFile();
			 Template conftempalte = VelocityUtil.getTemplate("/gencode/ui/"+gencodeService.getTheme()+"/listinfo.vm");
			 VelocityContext context = new VelocityContext();
			
			 
			 context.put("company", gencodeService.getModuleMetaInfo().getCompany());
			 context.put("gendate", gencodeService.getModuleMetaInfo().getDate());
			 context.put("author", gencodeService.getModuleMetaInfo().getAuthor());
			 context.put("version", gencodeService.getModuleMetaInfo().getVersion());
			 
			 context.put("conditions", gencodeService.getConditions());
			 context.put("fields", gencodeService.getListShowFields());
			 context.put("hiddenfields", gencodeService.getListHiddenFields());
			 
			 context.put("moduleName", gencodeService.getModuleMetaInfo().getModuleName());
			 context.put("moduleCNName", gencodeService.getModuleMetaInfo().getModuleCNName());
			 context.put("entityVarName", gencodeService.getEntityParamName());
			 context.put("entityName", gencodeService.getEntityName());
			 context.put("primaryKeyName", gencodeService.getPrimaryKeyName());
			 context.put("primaryKeyField", gencodeService.getPrimaryField());
			 context.put("genI18n", gencodeService.isGenI18n());
			 context.put("relativePath", gencodeService.getRelativePath());
			 context.put("namespacei18n", gencodeService.getNamespacei18n());
			 gencodeService.writFile(context,conftempalte,conf,gencodeService.getModuleMetaInfo().getEncodecharset());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
