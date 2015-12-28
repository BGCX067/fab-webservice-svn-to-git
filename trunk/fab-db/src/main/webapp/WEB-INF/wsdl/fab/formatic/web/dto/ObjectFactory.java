
package fab.formatic.web.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fab.formatic.web.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetServiceInfoResponse_QNAME = new QName("http://fab/", "getServiceInfoResponse");
    private final static QName _GetServiceInfo_QNAME = new QName("http://fab/", "getServiceInfo");
    private final static QName _OrderInput_QNAME = new QName("http://fab/", "OrderInput");
    private final static QName _OrderTracking_QNAME = new QName("http://fab/", "OrderTracking");
    private final static QName _OrderTrackingResponse_QNAME = new QName("http://fab/", "OrderTrackingResponse");
    private final static QName _IncidentTrackingResponse_QNAME = new QName("http://fab/", "IncidentTrackingResponse");
    private final static QName _GetServiceList_QNAME = new QName("http://fab/", "GetServiceList");
    private final static QName _GetBillingDataResponse_QNAME = new QName("http://fab/", "GetBillingDataResponse");
    private final static QName _BillTransaction_QNAME = new QName("http://fab/", "BillTransaction");
    private final static QName _GetTarrifResponse_QNAME = new QName("http://fab/", "GetTarrifResponse");
    private final static QName _GetServiceResponse_QNAME = new QName("http://fab/", "GetServiceResponse");
    private final static QName _IncidentTracking_QNAME = new QName("http://fab/", "IncidentTracking");
    private final static QName _GetModuleInfo_QNAME = new QName("http://fab/", "getModuleInfo");
    private final static QName _GetService_QNAME = new QName("http://fab/", "GetService");
    private final static QName _OrderInputResponse_QNAME = new QName("http://fab/", "OrderInputResponse");
    private final static QName _IncidentInput_QNAME = new QName("http://fab/", "IncidentInput");
    private final static QName _Login_QNAME = new QName("http://fab/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://fab/", "loginResponse");
    private final static QName _GetBillingData_QNAME = new QName("http://fab/", "GetBillingData");
    private final static QName _UpdateBillInfoResponse_QNAME = new QName("http://fab/", "UpdateBillInfoResponse");
    private final static QName _GetModuleInfoResponse_QNAME = new QName("http://fab/", "getModuleInfoResponse");
    private final static QName _GetServiceData_QNAME = new QName("http://fab/", "GetServiceData");
    private final static QName _GetServiceListResponse_QNAME = new QName("http://fab/", "GetServiceListResponse");
    private final static QName _GetServiceDataResponse_QNAME = new QName("http://fab/", "GetServiceDataResponse");
    private final static QName _UpdateBillInfo_QNAME = new QName("http://fab/", "UpdateBillInfo");
    private final static QName _IncidentInputResponse_QNAME = new QName("http://fab/", "IncidentInputResponse");
    private final static QName _BillTransactionResponse_QNAME = new QName("http://fab/", "BillTransactionResponse");
    private final static QName _GetTarrif_QNAME = new QName("http://fab/", "GetTarrif");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fab.formatic.web.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TarrifList }
     * 
     */
    public TarrifList createTarrifList() {
        return new TarrifList();
    }

    /**
     * Create an instance of {@link GetTarrifResponse }
     * 
     */
    public GetTarrifResponse createGetTarrifResponse() {
        return new GetTarrifResponse();
    }

    /**
     * Create an instance of {@link GetBillingDataResponse }
     * 
     */
    public GetBillingDataResponse createGetBillingDataResponse() {
        return new GetBillingDataResponse();
    }

    /**
     * Create an instance of {@link BillTransaction }
     * 
     */
    public BillTransaction createBillTransaction() {
        return new BillTransaction();
    }

    /**
     * Create an instance of {@link GetServiceListResponse }
     * 
     */
    public GetServiceListResponse createGetServiceListResponse() {
        return new GetServiceListResponse();
    }

    /**
     * Create an instance of {@link GetModuleInfoResponse }
     * 
     */
    public GetModuleInfoResponse createGetModuleInfoResponse() {
        return new GetModuleInfoResponse();
    }

    /**
     * Create an instance of {@link GetTarrif }
     * 
     */
    public GetTarrif createGetTarrif() {
        return new GetTarrif();
    }

    /**
     * Create an instance of {@link GetService }
     * 
     */
    public GetService createGetService() {
        return new GetService();
    }

    /**
     * Create an instance of {@link OrderInputOutput }
     * 
     */
    public OrderInputOutput createOrderInputOutput() {
        return new OrderInputOutput();
    }

    /**
     * Create an instance of {@link GetServiceInfo }
     * 
     */
    public GetServiceInfo createGetServiceInfo() {
        return new GetServiceInfo();
    }

    /**
     * Create an instance of {@link ServiceAttr }
     * 
     */
    public ServiceAttr createServiceAttr() {
        return new ServiceAttr();
    }

    /**
     * Create an instance of {@link OutAttr }
     * 
     */
    public OutAttr createOutAttr() {
        return new OutAttr();
    }

    /**
     * Create an instance of {@link GetModuleInfo }
     * 
     */
    public GetModuleInfo createGetModuleInfo() {
        return new GetModuleInfo();
    }

    /**
     * Create an instance of {@link GetServiceResponse }
     * 
     */
    public GetServiceResponse createGetServiceResponse() {
        return new GetServiceResponse();
    }

    /**
     * Create an instance of {@link GetTarrifOutput }
     * 
     */
    public GetTarrifOutput createGetTarrifOutput() {
        return new GetTarrifOutput();
    }

    /**
     * Create an instance of {@link IncidentInput }
     * 
     */
    public IncidentInput createIncidentInput() {
        return new IncidentInput();
    }

    /**
     * Create an instance of {@link IncidentInputResponse }
     * 
     */
    public IncidentInputResponse createIncidentInputResponse() {
        return new IncidentInputResponse();
    }

    /**
     * Create an instance of {@link GetServiceInfoResponse }
     * 
     */
    public GetServiceInfoResponse createGetServiceInfoResponse() {
        return new GetServiceInfoResponse();
    }

    /**
     * Create an instance of {@link BillingData }
     * 
     */
    public BillingData createBillingData() {
        return new BillingData();
    }

    /**
     * Create an instance of {@link UpdateBillInfo }
     * 
     */
    public UpdateBillInfo createUpdateBillInfo() {
        return new UpdateBillInfo();
    }

    /**
     * Create an instance of {@link Trans }
     * 
     */
    public Trans createTrans() {
        return new Trans();
    }

    /**
     * Create an instance of {@link IncidentTrackingOutput }
     * 
     */
    public IncidentTrackingOutput createIncidentTrackingOutput() {
        return new IncidentTrackingOutput();
    }

    /**
     * Create an instance of {@link IncidentTracking }
     * 
     */
    public IncidentTracking createIncidentTracking() {
        return new IncidentTracking();
    }

    /**
     * Create an instance of {@link ServiceList }
     * 
     */
    public ServiceList createServiceList() {
        return new ServiceList();
    }

    /**
     * Create an instance of {@link GetServiceList }
     * 
     */
    public GetServiceList createGetServiceList() {
        return new GetServiceList();
    }

    /**
     * Create an instance of {@link BillTransactionResponse }
     * 
     */
    public BillTransactionResponse createBillTransactionResponse() {
        return new BillTransactionResponse();
    }

    /**
     * Create an instance of {@link UpdateBillInfoOutput }
     * 
     */
    public UpdateBillInfoOutput createUpdateBillInfoOutput() {
        return new UpdateBillInfoOutput();
    }

    /**
     * Create an instance of {@link Module }
     * 
     */
    public Module createModule() {
        return new Module();
    }

    /**
     * Create an instance of {@link GetServiceOutput }
     * 
     */
    public GetServiceOutput createGetServiceOutput() {
        return new GetServiceOutput();
    }

    /**
     * Create an instance of {@link IncidentInputOutput }
     * 
     */
    public IncidentInputOutput createIncidentInputOutput() {
        return new IncidentInputOutput();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link OrderInputResponse }
     * 
     */
    public OrderInputResponse createOrderInputResponse() {
        return new OrderInputResponse();
    }

    /**
     * Create an instance of {@link GetServiceDataResponse }
     * 
     */
    public GetServiceDataResponse createGetServiceDataResponse() {
        return new GetServiceDataResponse();
    }

    /**
     * Create an instance of {@link IncidentTrackingResponse }
     * 
     */
    public IncidentTrackingResponse createIncidentTrackingResponse() {
        return new IncidentTrackingResponse();
    }

    /**
     * Create an instance of {@link OrderTracking }
     * 
     */
    public OrderTracking createOrderTracking() {
        return new OrderTracking();
    }

    /**
     * Create an instance of {@link Package }
     * 
     */
    public Package createPackage() {
        return new Package();
    }

    /**
     * Create an instance of {@link GetBillingData }
     * 
     */
    public GetBillingData createGetBillingData() {
        return new GetBillingData();
    }

    /**
     * Create an instance of {@link GetBillingDataOutput }
     * 
     */
    public GetBillingDataOutput createGetBillingDataOutput() {
        return new GetBillingDataOutput();
    }

    /**
     * Create an instance of {@link ServiceDataList }
     * 
     */
    public ServiceDataList createServiceDataList() {
        return new ServiceDataList();
    }

    /**
     * Create an instance of {@link GetServiceDataOutput }
     * 
     */
    public GetServiceDataOutput createGetServiceDataOutput() {
        return new GetServiceDataOutput();
    }

    /**
     * Create an instance of {@link OrderInput }
     * 
     */
    public OrderInput createOrderInput() {
        return new OrderInput();
    }

    /**
     * Create an instance of {@link BillTransactionOutput }
     * 
     */
    public BillTransactionOutput createBillTransactionOutput() {
        return new BillTransactionOutput();
    }

    /**
     * Create an instance of {@link OrderTrackingResponse }
     * 
     */
    public OrderTrackingResponse createOrderTrackingResponse() {
        return new OrderTrackingResponse();
    }

    /**
     * Create an instance of {@link GetServiceListOutput }
     * 
     */
    public GetServiceListOutput createGetServiceListOutput() {
        return new GetServiceListOutput();
    }

    /**
     * Create an instance of {@link Number }
     * 
     */
    public Number createNumber() {
        return new Number();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetServiceData }
     * 
     */
    public GetServiceData createGetServiceData() {
        return new GetServiceData();
    }

    /**
     * Create an instance of {@link UpdateBillInfoResponse }
     * 
     */
    public UpdateBillInfoResponse createUpdateBillInfoResponse() {
        return new UpdateBillInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "getServiceInfoResponse")
    public JAXBElement<GetServiceInfoResponse> createGetServiceInfoResponse(GetServiceInfoResponse value) {
        return new JAXBElement<GetServiceInfoResponse>(_GetServiceInfoResponse_QNAME, GetServiceInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "getServiceInfo")
    public JAXBElement<GetServiceInfo> createGetServiceInfo(GetServiceInfo value) {
        return new JAXBElement<GetServiceInfo>(_GetServiceInfo_QNAME, GetServiceInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "OrderInput")
    public JAXBElement<OrderInput> createOrderInput(OrderInput value) {
        return new JAXBElement<OrderInput>(_OrderInput_QNAME, OrderInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTracking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "OrderTracking")
    public JAXBElement<OrderTracking> createOrderTracking(OrderTracking value) {
        return new JAXBElement<OrderTracking>(_OrderTracking_QNAME, OrderTracking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTrackingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "OrderTrackingResponse")
    public JAXBElement<OrderTrackingResponse> createOrderTrackingResponse(OrderTrackingResponse value) {
        return new JAXBElement<OrderTrackingResponse>(_OrderTrackingResponse_QNAME, OrderTrackingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentTrackingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "IncidentTrackingResponse")
    public JAXBElement<IncidentTrackingResponse> createIncidentTrackingResponse(IncidentTrackingResponse value) {
        return new JAXBElement<IncidentTrackingResponse>(_IncidentTrackingResponse_QNAME, IncidentTrackingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetServiceList")
    public JAXBElement<GetServiceList> createGetServiceList(GetServiceList value) {
        return new JAXBElement<GetServiceList>(_GetServiceList_QNAME, GetServiceList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBillingDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetBillingDataResponse")
    public JAXBElement<GetBillingDataResponse> createGetBillingDataResponse(GetBillingDataResponse value) {
        return new JAXBElement<GetBillingDataResponse>(_GetBillingDataResponse_QNAME, GetBillingDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "BillTransaction")
    public JAXBElement<BillTransaction> createBillTransaction(BillTransaction value) {
        return new JAXBElement<BillTransaction>(_BillTransaction_QNAME, BillTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTarrifResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetTarrifResponse")
    public JAXBElement<GetTarrifResponse> createGetTarrifResponse(GetTarrifResponse value) {
        return new JAXBElement<GetTarrifResponse>(_GetTarrifResponse_QNAME, GetTarrifResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetServiceResponse")
    public JAXBElement<GetServiceResponse> createGetServiceResponse(GetServiceResponse value) {
        return new JAXBElement<GetServiceResponse>(_GetServiceResponse_QNAME, GetServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentTracking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "IncidentTracking")
    public JAXBElement<IncidentTracking> createIncidentTracking(IncidentTracking value) {
        return new JAXBElement<IncidentTracking>(_IncidentTracking_QNAME, IncidentTracking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModuleInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "getModuleInfo")
    public JAXBElement<GetModuleInfo> createGetModuleInfo(GetModuleInfo value) {
        return new JAXBElement<GetModuleInfo>(_GetModuleInfo_QNAME, GetModuleInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetService")
    public JAXBElement<GetService> createGetService(GetService value) {
        return new JAXBElement<GetService>(_GetService_QNAME, GetService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInputResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "OrderInputResponse")
    public JAXBElement<OrderInputResponse> createOrderInputResponse(OrderInputResponse value) {
        return new JAXBElement<OrderInputResponse>(_OrderInputResponse_QNAME, OrderInputResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "IncidentInput")
    public JAXBElement<IncidentInput> createIncidentInput(IncidentInput value) {
        return new JAXBElement<IncidentInput>(_IncidentInput_QNAME, IncidentInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBillingData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetBillingData")
    public JAXBElement<GetBillingData> createGetBillingData(GetBillingData value) {
        return new JAXBElement<GetBillingData>(_GetBillingData_QNAME, GetBillingData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBillInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "UpdateBillInfoResponse")
    public JAXBElement<UpdateBillInfoResponse> createUpdateBillInfoResponse(UpdateBillInfoResponse value) {
        return new JAXBElement<UpdateBillInfoResponse>(_UpdateBillInfoResponse_QNAME, UpdateBillInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModuleInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "getModuleInfoResponse")
    public JAXBElement<GetModuleInfoResponse> createGetModuleInfoResponse(GetModuleInfoResponse value) {
        return new JAXBElement<GetModuleInfoResponse>(_GetModuleInfoResponse_QNAME, GetModuleInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetServiceData")
    public JAXBElement<GetServiceData> createGetServiceData(GetServiceData value) {
        return new JAXBElement<GetServiceData>(_GetServiceData_QNAME, GetServiceData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetServiceListResponse")
    public JAXBElement<GetServiceListResponse> createGetServiceListResponse(GetServiceListResponse value) {
        return new JAXBElement<GetServiceListResponse>(_GetServiceListResponse_QNAME, GetServiceListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetServiceDataResponse")
    public JAXBElement<GetServiceDataResponse> createGetServiceDataResponse(GetServiceDataResponse value) {
        return new JAXBElement<GetServiceDataResponse>(_GetServiceDataResponse_QNAME, GetServiceDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBillInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "UpdateBillInfo")
    public JAXBElement<UpdateBillInfo> createUpdateBillInfo(UpdateBillInfo value) {
        return new JAXBElement<UpdateBillInfo>(_UpdateBillInfo_QNAME, UpdateBillInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentInputResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "IncidentInputResponse")
    public JAXBElement<IncidentInputResponse> createIncidentInputResponse(IncidentInputResponse value) {
        return new JAXBElement<IncidentInputResponse>(_IncidentInputResponse_QNAME, IncidentInputResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "BillTransactionResponse")
    public JAXBElement<BillTransactionResponse> createBillTransactionResponse(BillTransactionResponse value) {
        return new JAXBElement<BillTransactionResponse>(_BillTransactionResponse_QNAME, BillTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTarrif }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fab/", name = "GetTarrif")
    public JAXBElement<GetTarrif> createGetTarrif(GetTarrif value) {
        return new JAXBElement<GetTarrif>(_GetTarrif_QNAME, GetTarrif.class, null, value);
    }

}
