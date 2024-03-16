/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DAL_Shift;
import Entity.Service;
import Entity.Shift;
import java.util.ArrayList;

/**
 *
 * @author Win 8 32bit VS7
 */
public class DLL_Shift {
    DAL_Shift shift = new DAL_Shift();
    public ArrayList<Shift> showShiftname() {
        return shift.showShiftname();
    }
    public boolean getCode(String code , String shiftName){
        return shift.getCode(code, shiftName);
    }
    public boolean delelteShift(String code){
        return shift.deleteShift(code);
    }
}
