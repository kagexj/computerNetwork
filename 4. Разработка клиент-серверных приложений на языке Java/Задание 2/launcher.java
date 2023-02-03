
public class launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MyClient.main(null);
				
			}
		}).start();
	new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					MyClient.main(null);
					
				}
			}).start();
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			MyClient.main(null);
			
		}
	}).start();
	}
}
