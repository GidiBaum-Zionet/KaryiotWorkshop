import {IElementCount} from "./IElementCount";


export interface IMoleculeModel {
  formula: String;
  molecularWeight: number;
  elementCounts: IElementCount[];
}
