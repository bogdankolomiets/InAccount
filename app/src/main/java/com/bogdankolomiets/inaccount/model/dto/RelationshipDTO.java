package com.bogdankolomiets.inaccount.model.dto;

/**
 * @author bogdan
 * @version 1
 * @date 23.05.17
 */

public class RelationshipDTO {
    public Data data;

    public class Data {
        public String outgoing_status;
        public String incoming_status;
    }
}
