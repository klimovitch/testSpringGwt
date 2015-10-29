package com.netCracker.testSpringGwt.client;

import com.google.gwt.user.client.ui.Button;

public class ButtonWithIndex extends Button {
	
		private int index;
		private String nameOfButton;

		public ButtonWithIndex(String nameOfButton, int index) {
			super(nameOfButton);
			this.nameOfButton = nameOfButton;
			this.index = index;
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + ((nameOfButton == null) ? 0 : nameOfButton.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ButtonWithIndex other = (ButtonWithIndex) obj;
			if (index != other.index)
				return false;
			if (nameOfButton == null) {
				if (other.nameOfButton != null)
					return false;
			} else if (!nameOfButton.equals(other.nameOfButton))
				return false;
			return true;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getNameOfButton() {
			return nameOfButton;
		}

		public void setNameOfButton(String nameOfButton) {
			this.nameOfButton = nameOfButton;
		}

	}


