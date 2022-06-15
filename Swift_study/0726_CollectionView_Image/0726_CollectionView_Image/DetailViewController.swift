//
//  DetailViewController.swift
//  0726_CollectionView_Image
//
//  Created by Seong A Oh on 2021/07/26.
//

import UIKit

class DetailViewController: UIViewController {
    @IBOutlet weak var imgView: UIImageView!
    
    var receiveItem = "" // ViewController에서 데이터를 받아서 저장할 곳

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        imgView.image = UIImage(named: receiveItem)
    }
    
    // ViewController에서 데이터를 받아오기
    func receiveItems(_ item: String){
        receiveItem = item
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
