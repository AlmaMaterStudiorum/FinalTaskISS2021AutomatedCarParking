%====================================================================================
% parkingmanagerservicesystem description   
%====================================================================================
context(ctxclientguiparkin, "localhost\\clientguiparkin",  "TCP", "10100").
context(ctxclientguiparkout, "localhost\\ctxclientguiparkout",  "TCP", "10200").
context(ctxclientparkin, "localhost",  "TCP", "10101").
context(ctxclientparkout, "localhost",  "TCP", "10201").
context(ctxcommand, "localhost",  "TCP", "10300").
context(ctxservergui, "localhost",  "TCP", "10400").
context(ctxserver, "localhost",  "TCP", "10401").
context(ctxsimgui, "localhost",  "TCP", "10500").
context(ctxsim, "localhost",  "TCP", "10501").
 qactor( clientguiparkin, ctxclientguiparkin, "external").
  qactor( clientguiparkout, ctxclientguiparkout, "external").
  qactor( servergui, ctxservergui, "external").
  qactor( clientparkin, ctxclientparkin, "it.unibo.clientparkin.Clientparkin").
  qactor( statusactor, ctxcommand, "it.unibo.statusactor.Statusactor").
