program MachineConvert;
uses SysUtils;

type
    State = 1..100;
    StateSet = set of State;


(* program variables *)
type
    Transition = record
                    init : State;
                    t : set of 'a'..'z';
                    final : State;
                 end;

var Q : StateSet;
var R : TList;
var q0 : State;
var F : StateSet;

var Qp : StateSet;
var Rp : TList;
var q0p : State;
var Fp : StateSet;

(* program entry *)
begin

end.
