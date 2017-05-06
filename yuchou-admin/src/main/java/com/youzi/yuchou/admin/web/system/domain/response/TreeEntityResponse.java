package com.youzi.yuchou.admin.web.system.domain.response;


public class TreeEntityResponse {
	
		private int id;
		private String name;
		private boolean isParent;
		private int pId;
		private String url;
		private boolean checked;
		private boolean open;
		private String iconOpen;
		private String iconClose;
		private int level;
		private String description;
		private boolean visibility;
		private String icon;
		private Integer orderNumber;
		
		
		public Integer getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(Integer orderNumber) {
			this.orderNumber = orderNumber;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isVisibility() {
			return visibility;
		}
		public void setVisibility(boolean visibility) {
			this.visibility = visibility;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean getIsParent() {
			return isParent;
		}
		public void setIsParent(boolean isParent) {
			this.isParent = isParent;
		}
		public int getpId() {
			return pId;
		}
		public void setpId(int pId) {
			this.pId = pId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public boolean isChecked() {
			return checked;
		}
		public void setChecked(boolean checked) {
			this.checked = checked;
		}
		public boolean isOpen() {
			return open;
		}
		public void setOpen(boolean open) {
			this.open = open;
		}
		public String getIconOpen() {
			return iconOpen;
		}
		public void setIconOpen(String iconOpen) {
			this.iconOpen = iconOpen;
		}
		public String getIconClose() {
			return iconClose;
		}
		public void setIconClose(String iconClose) {
			this.iconClose = iconClose;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		
		
		
}
