package TODOApp;

public class Item {
		private String todo;
		private String status;

		protected Item(String todo) {
			this.todo = todo;
			this.status = "N";
		}

		protected Item(String todo, String status) {
			this.todo = todo;
			this.status = status;
		}

		protected void setTodo(String todo) {
			this.todo = todo;
		}
		protected void setStatus(String status) {
			this.status = status;
		}
		protected String getTodo() {
			return todo;
		}
		protected String getStatus() {
			return status;
		}
}

