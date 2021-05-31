package com.example.paymentlist.rest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPaymentMethodsResponse {
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultInfo")
    @Expose
    private String resultInfo;
    @SerializedName("returnCode")
    @Expose
    private ReturnCode returnCode;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("interaction")
    @Expose
    private Interaction interaction;
    @SerializedName("identification")
    @Expose
    private Identification identification;
    @SerializedName("networks")
    @Expose
    private Networks networks;
    @SerializedName("operationType")
    @Expose
    private String operationType;
    @SerializedName("style")
    @Expose
    private Style style;
    @SerializedName("payment")
    @Expose
    private Payment payment;
    @SerializedName("integrationType")
    @Expose
    private String integrationType;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public Networks getNetworks() {
        return networks;
    }

    public void setNetworks(Networks networks) {
        this.networks = networks;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public class Applicable {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("method")
        @Expose
        private String method;
        @SerializedName("grouping")
        @Expose
        private String grouping;
        @SerializedName("registration")
        @Expose
        private String registration;
        @SerializedName("recurrence")
        @Expose
        private String recurrence;
        @SerializedName("redirect")
        @Expose
        private boolean redirect;
        @SerializedName("links")
        @Expose
        private Links__1 links;
        @SerializedName("selected")
        @Expose
        private boolean selected;
        @SerializedName("inputElements")
        @Expose
        private List<InputElement> inputElements = null;
        @SerializedName("operationType")
        @Expose
        private String operationType;
        @SerializedName("contractData")
        @Expose
        private ContractData contractData;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getGrouping() {
            return grouping;
        }

        public void setGrouping(String grouping) {
            this.grouping = grouping;
        }

        public String getRegistration() {
            return registration;
        }

        public void setRegistration(String registration) {
            this.registration = registration;
        }

        public String getRecurrence() {
            return recurrence;
        }

        public void setRecurrence(String recurrence) {
            this.recurrence = recurrence;
        }

        public boolean isRedirect() {
            return redirect;
        }

        public void setRedirect(boolean redirect) {
            this.redirect = redirect;
        }

        public Links__1 getLinks() {
            return links;
        }

        public void setLinks(Links__1 links) {
            this.links = links;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public List<InputElement> getInputElements() {
            return inputElements;
        }

        public void setInputElements(List<InputElement> inputElements) {
            this.inputElements = inputElements;
        }

        public String getOperationType() {
            return operationType;
        }

        public void setOperationType(String operationType) {
            this.operationType = operationType;
        }

        public ContractData getContractData() {
            return contractData;
        }

        public void setContractData(ContractData contractData) {
            this.contractData = contractData;
        }

    }

    public class ContractData {

        @SerializedName("PAGE_ENVIRONMENT")
        @Expose
        private String pageEnvironment;
        @SerializedName("JAVASCRIPT_INTEGRATION")
        @Expose
        private String javascriptIntegration;
        @SerializedName("PAGE_BUTTON_LOCALE")
        @Expose
        private String pageButtonLocale;

        public String getPageEnvironment() {
            return pageEnvironment;
        }

        public void setPageEnvironment(String pageEnvironment) {
            this.pageEnvironment = pageEnvironment;
        }

        public String getJavascriptIntegration() {
            return javascriptIntegration;
        }

        public void setJavascriptIntegration(String javascriptIntegration) {
            this.javascriptIntegration = javascriptIntegration;
        }

        public String getPageButtonLocale() {
            return pageButtonLocale;
        }

        public void setPageButtonLocale(String pageButtonLocale) {
            this.pageButtonLocale = pageButtonLocale;
        }

    }

    public class Identification {

        @SerializedName("longId")
        @Expose
        private String longId;
        @SerializedName("shortId")
        @Expose
        private String shortId;
        @SerializedName("transactionId")
        @Expose
        private String transactionId;

        public String getLongId() {
            return longId;
        }

        public void setLongId(String longId) {
            this.longId = longId;
        }

        public String getShortId() {
            return shortId;
        }

        public void setShortId(String shortId) {
            this.shortId = shortId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

    }

    public class InputElement {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("type")
        @Expose
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public class Interaction {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("reason")
        @Expose
        private String reason;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

    }

    public class Links {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("lang")
        @Expose
        private String lang;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

    }

    public class Links__1 {

        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("lang")
        @Expose
        private String lang;
        @SerializedName("operation")
        @Expose
        private String operation;
        @SerializedName("validation")
        @Expose
        private String validation;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getValidation() {
            return validation;
        }

        public void setValidation(String validation) {
            this.validation = validation;
        }

    }

    public class Networks {

        @SerializedName("applicable")
        @Expose
        private List<Applicable> applicable = null;

        public List<Applicable> getApplicable() {
            return applicable;
        }

        public void setApplicable(List<Applicable> applicable) {
            this.applicable = applicable;
        }

    }

    public class Payment {

        @SerializedName("reference")
        @Expose
        private String reference;
        @SerializedName("amount")
        @Expose
        private int amount;
        @SerializedName("currency")
        @Expose
        private String currency;

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }

    public class ReturnCode {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("source")
        @Expose
        private String source;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

    }

    public class Status {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("reason")
        @Expose
        private String reason;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

    }

    public class Style {

        @SerializedName("language")
        @Expose
        private String language;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

    }
}

