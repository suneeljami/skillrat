package infotech.vns.com.network;

import infotech.vns.com.model.CustomerData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {
    @FormUrlEncoded
    @POST("customer/create")
    /*{
        "firstName":"sk",
            "lastName":"jami"
        "mobile":"99999999999"
    }*/

    Call<CustomerData> insertCustomer(@Field("firstName") String fname,
                                      @Field("lastName") String lname,
                                      @Field("mobile") String mobile);
}