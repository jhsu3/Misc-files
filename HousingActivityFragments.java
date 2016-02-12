//OnCreate
mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
savedPos = mSharedPreferences.getInt(USERHOUSINGPOS, 0);
userHousingSpinner.setSelection(savedPos);

//OnItemSelected
SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
prefsEditor.putInt(USERHOUSINGPOS, pos);
prefsEditor.commit();
savedPos = pos;

//ServiceDeskButton
serviceDeskButton = (Button) findViewById(R.id.serviceDeskButton);
serviceDeskButton.setOnClickListener(new OnClickListener()
{

	@Override
	public void onClick(View parent) 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(HousingActivity.this);
	    builder.setTitle("Service Desk Numbers")
	           .setItems(R.array.planets_array, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int pos) {
	               Intent dialIntent = new Intent(Intent.ACTION_DIAL);
	               String telNumber = "tel:"+"704-995-7183";
	               dialIntent.setData(Uri.parse(telNumber));
	               startActivity(dialIntent);
	           }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
});

//Service desk list adapter
public class HousingServiceDeskAdapter extends BaseAdapter
{
	Context mContext;
	LayoutInflater mInflater;
	
	public HousingServiceDeskAdapter(Context context, LayoutInflater inflater)
	{
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
	}
	
	private class ViewHolder
	{
		public TextView name;
		public TextView number;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ViewHolder holder;
		if(convertView==null)
		{
			convertView = mInflater.inflate(R.layout.listrow, parent, false);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.textListItemName);
			holder.number = (TextView) convertView.findViewById(R.id.textListItemDescription);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
}

//Service Desk alert dialog adapter
serviceDeskButton = (Button) findViewById(R.id.serviceDeskButton);
serviceDeskButton.setOnClickListener(new OnClickListener()
{

	@Override
	public void onClick(View parent) 
	{
		HousingServiceDeskAdapter adapter = new HousingServiceDeskAdapter(parent.getContext(), getLayoutInflater());
		AlertDialog.Builder builder = new AlertDialog.Builder(HousingActivity.this);
	    /*builder.setTitle("Service Desk Numbers")
	           .setItems(R.array.planets_array, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int pos) {
	               Intent dialIntent = new Intent(Intent.ACTION_DIAL);
	               String telNumber = "tel:"+"704-995-7183";
	               dialIntent.setData(Uri.parse(telNumber));
	               startActivity(dialIntent);
	           }
	    });*/
		
		builder.setTitle("Service Desk Numbers")
           .setAdapter(adapter, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int pos) {
               Intent dialIntent = new Intent(Intent.ACTION_DIAL);
               String telNumber = "tel:"+"704-995-7183";
               dialIntent.setData(Uri.parse(telNumber));
               startActivity(dialIntent);
           }
        });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
});