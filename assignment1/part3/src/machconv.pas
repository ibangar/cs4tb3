(*
 *  This program converts an NFA to a DFA. The
 *  format of the input is as follows.
 *
 *  q0
 *  a0 t0 b0
 *  ...
 *  an tn bn
 *  r0 r1 ... rn
 *
 * q0 is the initial state,
 *      q0 is an integer.
 * an tn bn represents a transition from an to bn through tn,
 *      an, bn are integers,
 *      tn is a symbol.
 * r0, r1, ..., rn are final states,
 *      r0, ..., rn are integers.
 *
 *)
program MachineConvert;
uses SysUtils;

(* vocabulary *)
type
    T = 'a'..'z';

(* states *)
type
    Q = 1..100;

type
    Transition =
        record
            src : Q;
            t : T;
            dst : Q;
        end;

type
    TransitionSet =
        record
            src : set of Q;
            t : T;
            dst : set of Q;
        end;

(* (T,Q,R,q0,F) represents the input state machine *)
var R : array of Transition;
var q0 : Q;
var F : set of Q;

(* (T,Qp,Rp,q0p,Fp) represents the output state machine *)
var Qp : array of set of Q;
var Rp : array of TransitionSet;
var q0p : set of Q;
var Fp : array of set of Q;

(* program variables *)
var s : Q;
var ss, srp : set of Q;
var tr : Transition;
var trs : TransitionSet;
var c : Char;
var i : Integer;
var sym : T;

(* program entry *)
begin
    (* get initial state *)
    readln(q0);

    (* get final states *)
    while not EoLn() do
    begin
        read(s);
        include(F, s);
    end;

    (* get all transitions *)
    while not Eof() do
    begin
        read(tr.src, c, tr.t, c, tr.dst);
        if (EoF()) then
            break;
        SetLength(R, Length(R) + 1);
        R[Length(R) - 1] := tr;
    end;

    (********************************
     * SUBSET CONSTRUCTION ALGORITHM
     *******************************)
    q0p := [q0];
    SetLength(Qp, 1); Qp[0] := q0p;

    (* for all q' in Q' *)
    while i < Length(Qp) do
    begin
        ss := Qp[i];

        (* for any t in T *)
        for sym in T do
        begin
            (* srp = the set of dst states in R that match src = s in Qp and sym *)
            srp := [];
            for tr in R do
            begin
                if (tr.t = sym) then
                begin
                    for s in ss do
                    begin
                        if (tr.src = s) then
                        begin
                            include(srp, tr.dst);
                        end;
                    end;
                end;
            end;

            (* if srp isn't empty, add it to Qp and add the transition to Rp *)
            if not (srp = []) then
            begin
                SetLength(Qp, Length(Qp)+1);
                Qp[Length(Qp) - 1] := srp;

                trs.src := ss;
                trs.t := sym;
                trs.dst := srp;

                SetLength(Rp, Length(Rp)+1);
                Rp[Length(Rp) - 1] := trs;
            end;
        end;

        (* next unchecked element of Qp *)
        i := i + 1;
    end;

    (* Let Fp = the set of qp such that f is in qp and f is in F *)
    for ss in Qp do
    begin
        for s in F do
        begin
            if (s in ss) then
            begin
                SetLength(Fp, Length(Fp)+1);
                Fp[Length(Fp) - 1] := ss;
            end;
        end;
    end;

    (* print new initial state *)
    for s in q0p do
    begin
        write(s);
    end;
    writeln();

    (* print new final states *)
    for ss in Fp do
    begin
        for s in ss do
        begin
            write(s);
        end;
        write(' ');
    end;
    writeln();

    (* print new transitions *)
    for trs in Rp do
    begin
        for s in trs.src do
        begin
            write(s);
        end;
        write(' ', trs.t, ' ');
        for s in trs.dst do
        begin
            write(s);
        end;
        writeln();
    end;
end.
