
package com.youzi.yuchou.module.mvc.response.menu;

import java.io.Serializable;

import com.youzi.yuchou.module.model.model.SysMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SysUserMenuResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String htmlUrlKey;
	
	private SysMenu sysMenu;
	
	/*private Integer menuKy;

    private Integer pid;
    
    private String htmlUrl;
    
    private String url;

    private String name;

    private String image;

    private String request;

    private Integer attribute;

    private String remark;

    private Integer level;

    private Integer sort;*/

}
